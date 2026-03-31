public class TemperatureCalculator {

    public float hottestDay(float[][] avgTemp){
        float max = avgTemp[0][0];
        float day = 1 ;
        for(int i=1;i<avgTemp.length;i++){
            if(avgTemp[i][0] > max){
                max = avgTemp[i][0];
                day = i+1 ;
            }
        }
        return day;
    }
    public float coldestDay(float[][] avgTemp){
        float min = avgTemp[0][0];
        float day = 1 ;
        for(int i=1;i<avgTemp.length;i++){
            if(avgTemp[i][0] < min){
                min = avgTemp[i][0];
                day = i+1 ;
            }
        }
        return day;
    }
    public float coldestTemp(float[][] avgTemp){
        float min = avgTemp[0][0];
        for(int i=1;i<avgTemp.length;i++){
            if(avgTemp[i][0] < min)
                min = avgTemp[i][0];
        }
        return min;
    }
    public float hottestTemp(float[][] avgTemp){
        float max = avgTemp[0][0];
        for(int i=1;i<avgTemp.length;i++){
            if(avgTemp[i][0] > max)
                max = avgTemp[i][0];
        }
        return max;
    }

    public static void main(String[] args) {

        TemperatureCalculator tc = new TemperatureCalculator();

        float[][] arr = new float[7][24];
        float[][] avgTemp = new float[7][1];
        for(int i=0;i<arr.length;i++){
            float sum = 0 ;
            System.out.println("Enter Temp For Day "+(i+1)+", and ");
            for(int j=0;j<arr[0].length;j++){
                System.out.print("Hour "+(j+1)+" : ");
                arr[i][j] = (float)Math.random()*50;
                System.out.println(arr[i][j]);
                sum += arr[i][j];
            }
            avgTemp[i][0] = (sum/24) ;
        }
        for(int i=0;i<avgTemp.length;i++){
            System.out.println("Day "+(i+1)+", Average Temp : "+avgTemp[i][0]);
        }
        System.out.println("Coldest Day is : "+(int)tc.coldestDay(avgTemp)+", Temp : "+tc.coldestTemp(avgTemp));
        System.out.println("Hottest Day is : "+(int)tc.hottestDay(avgTemp)+", Temp : "+tc.hottestTemp(avgTemp));
    }
}
