package interfaces;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import java.util.List;

public interface CrudOperations<T> {
    void add(T item);
    T getById(String id);
    List<T> getAll();
    void update(T item);
    void delete(String id);
}