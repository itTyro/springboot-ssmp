package com.linzhilong.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linzhilong.domain.Book;

public interface BookService2 extends IService<Book> {
    IPage<Book> getPage(Integer current,Integer size,Book book);
}
