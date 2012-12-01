/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectionVault;

/**
 *
 * @author kevin
 */
public class RequestMsg<T> {
    
    private T t;
    /**
     * constructor
     */
    public RequestMsg(T pT) {
        System.out.print(pT.getClass());
        t=pT;
        
    }
    
    public T get(){
        System.out.print(t.getClass());
        return t;
    }
    
}
