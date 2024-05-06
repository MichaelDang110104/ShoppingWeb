/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;

/**
 *
 * @author Michael Dang
 */
public interface Accessible <T> {
    boolean insertRec (T obj);
    boolean updateRec (String id ,T obj);
    boolean deleteRec (String id);
    T getObjectById (String id);
    ArrayList<T> listAll();
}
