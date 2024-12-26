package repository;

import java.util.List;

public interface IService <T>{
    void save(T t);

    void remove(int id);

    List<T> getAll();

    List<T> findAllByName(String name);

    T findById(int id);
}
