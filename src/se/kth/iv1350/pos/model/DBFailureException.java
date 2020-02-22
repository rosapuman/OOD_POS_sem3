package se.kth.iv1350.pos.model;

/*Used for database failures*/
public class DBFailureException extends java.lang.RuntimeException{

    public DBFailureException(){
        super();
    }
    public DBFailureException(String msg){
        super(msg);
    }
}
