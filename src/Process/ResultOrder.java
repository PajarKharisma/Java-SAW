package Process;

import java.util.LinkedList;

public class ResultOrder {

    public LinkedList<ResultData> getResultData(ResultData[] arr) {
        int n = arr.length;
        ResultData temp = new ResultData();
        temp = null;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1].getResult() < arr[j].getResult()) {
                    //swap elements  
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }

        LinkedList<ResultData> list = new LinkedList();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
