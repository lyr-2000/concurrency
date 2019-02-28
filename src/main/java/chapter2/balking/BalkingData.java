package chapter2.balking;

import java.io.FileWriter;
import java.io.Writer;

/**
 * @author czd
 */
public class BalkingData {
    private  String fileName;

    private String context;

    private boolean changed;

    public BalkingData(String fileName , String context){
        this.fileName = fileName;
        this.context = context;
        this.changed = true;
    }

    public synchronized void change(String newContext){
        this.context = newContext;
        this.changed = true;
    }

    public synchronized void save(){
        if(!changed){
            return;
        }
        doSave();
        this.changed = false;
    }

    private void doSave(){
        System.out.println(Thread.currentThread().getName() + " save  >>>>  context = " + context);
        try {
            Writer writer = new FileWriter(fileName , true);
            writer.write(context);
            writer.write("\n");
            writer.flush();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
