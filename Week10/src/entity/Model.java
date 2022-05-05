package entity;

public class Model {
    
    private int modelId;
    private String model;
    
    public Model(int modelId, String model) {
        this.setModelId(modelId);
        this.setModel(model);
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    
    }
  


