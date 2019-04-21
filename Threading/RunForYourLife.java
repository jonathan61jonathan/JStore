package Threading;

import java.util.Random;
public class RunForYourLife implements Runnable
{
    String nama;
    
    public RunForYourLife(String nama)
    {
        setNama(nama);
        System.out.println(getNama() + ", ready.");
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    private int random(int max){
        return (int)(Math.random() * max + 1);
    }
    
    public void run(){
        System.out.println(getNama() + ", set ...");
        System.out.println(getNama() + ", go!");
        for(int i = 0; i<20; i++){
            try{
                Thread.sleep(random(100500));
            } catch (Exception e){
                System.out.println(e);
            }
            System.out.println(getNama() + " has passed checkpoint ("+ (i+1) +")" );
        }
        
        System.out.println(getNama() + " has finished!");
    }
    
    public static void main(String args[]) {
        (new Thread(new RunForYourLife("Lionel"))).start();
        (new Thread(new RunForYourLife("Andreas"))).start();
        (new Thread(new RunForYourLife("Messi"))).start();
    }
}
