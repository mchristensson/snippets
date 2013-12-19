package org.mac.gxml.writer.model;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.xmlbeans.XmlOptions;
import org.mac.gxml.enovia.model.impl.Relationship;
import org.mac.gxml.enovia.model.impl.Type;
import org.mac.gxml.model.BaseModelEntity;
import org.mac.gxml.model.ConnectionLine;
import org.mac.gxml.model.ModelEntity;
import org.mac.gxml.schema.StageDocument;
import org.mac.gxml.schema.StageDocument.Stage;
import org.mac.gxml.schema.StageDocument.Stage.PageObj;
import org.mac.gxml.schema.StageDocument.Stage.PageObj.Objects;

public abstract class XMIDocumentWrapperImpl implements XMIDocumentWrapper {
	@Override
	public void connectGliffyObjects() {
		Objects objs = doc.getStage().getPageObj().getObjects();
		Iterator<ModelEntity> modelObjIterator = objectIndex.values()
				.iterator();
		while (modelObjIterator.hasNext()) {
			ModelEntity source = modelObjIterator.next();
			Collection<Short> targets = source.getTargetIds();
			if (targets != null) {
				Iterator<Short> targetIter = targets.iterator();
				while (targetIter.hasNext()) {
					ModelEntity target = objectIndex.get(targetIter.next());
					BaseModelEntity connectionLine = new ConnectionLine(source,
							target);
					connectionLine.setObjectRef(objs.addNewObject());
				}
			}
		}

	}

	private final StageDocument doc;

	/**
	 * @param document
	 * @param file
	 * @throws IOException
	 */
	@Override
	public void save(File file) throws IOException {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSavePrettyPrint();
		doc.save(file, xmlOptions);
		System.out.print("File saved to " + file.getAbsoluteFile().toString());
	}

	private final Map<Short, ModelEntity> objectIndex = new HashMap<Short, ModelEntity>();
	private final Map<String, Short> idIndex = new HashMap<String, Short>();

	/**
	 * Adds an entity to temporary object index
	 * 
	 * @param symbolicName
	 * @param object
	 */
	@Override
	public void addToIndex(ModelEntity object) {
		Short key = new Short(object.getId());
		this.objectIndex.put(key, object);
		this.idIndex.put(object.getIdentifier(), key);
	}

	@Override
	public ModelEntity getFromIndex(String identifier) {
		Short key = this.idIndex.get(identifier);
		return this.objectIndex.get(key);
	}

	public ModelEntity getFromIndex(Short id) {
		return this.objectIndex.get(id);
	}

	public XMIDocumentWrapperImpl() {
		doc = StageDocument.Factory.newInstance();

		Stage stage = doc.addNewStage();
		stage.setVersion(3);

		PageObj page = stage.addNewPageObj();
		preparePage(page);

		page.addNewObjects();
	}

	protected abstract void preparePage(PageObj page);

	@Override
	public void generateGliffyObjects() {
		Objects objs = doc.getStage().getPageObj().getObjects();
		Iterator<ModelEntity> indexIter = objectIndex.values().iterator();
		while (indexIter.hasNext()) {
			ModelEntity modelEntity = indexIter.next();
			if (modelEntity instanceof Type) {
				modelEntity.setObjectRef(objs.addNewObject());
			} else if (modelEntity instanceof Relationship) {
				modelEntity.setObjectRef(objs.addNewObject());
			}
		}
	}
}
