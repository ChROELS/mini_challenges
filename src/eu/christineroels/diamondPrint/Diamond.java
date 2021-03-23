package eu.christineroels.diamondPrint;

public class Diamond {

    public static String print(int n){
        StringBuilder diamondBuilder = new StringBuilder();
        if(n<0){
            return null;
        }else {
            if (n % 2 == 0) {
                return null;
            }else{
                for(int i=1;i<=n;i+=2){
                    diamondBuilder.append(getDiamondLine(n,i));
                }
                for(int i=n;i>=1;i-=2){
                    if(i==n){
                        continue;
                    }
                    diamondBuilder.append(getDiamondLine(n,i));
                }
            }
        }
        return diamondBuilder.toString();
    }
    private static String getDiamondLine(int n, int i){
        String star = ("*").repeat(i);
        if(star.length()<n){
            star =" ".repeat((n-i)/2)+ star;
        }
        return star + "\n";
    }
}
