import java.util.ArrayList;

public class XMLDrug {

    static class DrugInt{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getInteraction() {
            return interaction;
        }

        public void setInteraction(String interaction) {
            this.interaction = interaction;
        }

        private String name;
        private String ID;
        private String interaction;

        DrugInt(){
            this.ID = ID;
            this.name = name;
            this.interaction= interaction;
        }


    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    private String id;
    private String indication;
    private ArrayList<DrugInt> drugInteractions;
    private String description;
    private ArrayList<DrugInt> drugInteractionList;

    public ArrayList<DrugInt> getDrugInteractionList() {
        return drugInteractionList;
    }

    public void setDrugInteractionList(ArrayList<DrugInt> drugInteractionList) {
        this.drugInteractionList = drugInteractionList;
    }




    XMLDrug( ){
        this.name = name;
        this.id = id;
        this.indication = indication;
        this.drugInteractions = drugInteractions;
        this.description = description;



    }




}