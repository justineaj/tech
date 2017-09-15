/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 9/17/16
 * Time: 1:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class CountWays {

    static int maxlength=5;
    static int count=0;

    static int tc1=0;
    static int tc2=0;
    public static void main(String args[]){

        System.out.println(new CountWays().cw1(maxlength));
        new CountWays().cw2(0);
        System.out.println(count);

        System.out.println(tc1);
        System.out.println(tc2);

    }


    private int cw1(int n){
        tc1++;
        if(n<0){
            return 0;
        }
        else if(n==0){
            return 1;
        }
        else{
            return cw1(n-1)+cw1(n-2)+cw1(n-3);
        }
    }

    private void cw2(int n){
        tc2++;
        if(n==maxlength){
             count++;
        }
        else if(n>maxlength){
           return ;
        }
        cw2(n+1);
        cw2(n+2);
        cw2(n+3);

    }





}
