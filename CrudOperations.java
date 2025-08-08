/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package LMS;
import java.util.List;

public interface CrudOperations<T> {
    void add(T item);
    T getById(int id);
    List<T> getAll();
    void update(T item);
    void delete(int id);
}