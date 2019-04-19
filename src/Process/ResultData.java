
package Process;

import java.util.LinkedList;

public class ResultData {
    private String alternatif;
    private String namaAlternatif;
    private double result;
    private LinkedList<Double> listValue;
    
    public LinkedList<Double> getListValue(){
        return listValue;
    }
    
    public void setListValue(LinkedList<Double> listValue){
        this.listValue = listValue;
    }

    public String getAlternatif() {
        return alternatif;
    }

    public void setAlternatif(String alternatif) {
        this.alternatif = alternatif;
    }

    public String getNamaAlternatif() {
        return namaAlternatif;
    }

    public void setNamaAlternatif(String namaAlternatif) {
        this.namaAlternatif = namaAlternatif;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
