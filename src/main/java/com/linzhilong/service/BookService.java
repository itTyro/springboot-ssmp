package com.linzhilong.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.linzhilong.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    boolean save(Book book);
    boolean update(Book book);
    boolean delete(Integer id);
    Book selectById(Integer id);
    List<Book> selectAll();
    IPage<Book> selectPage(Integer current,Integer size);
}
