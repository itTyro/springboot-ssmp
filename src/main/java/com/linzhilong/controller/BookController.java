package com.linzhilong.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.linzhilong.controller.utils.Result;
import com.linzhilong.domain.Book;
import com.linzhilong.service.BookService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService2 bookService2;

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService2.getById(id);
        return new Result(true,book);
    }

    @GetMapping
    public Result getAll() {
        List<Book> books = bookService2.list();
        return new Result(true,books);
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Integer id) {
        boolean flag = bookService2.removeById(id);
        return new Result(flag,flag ? "删除成功" : "删除失败");
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService2.updateById(book);
        return new Result(flag,flag ? "修改成功" : "修改失败");
    }


    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService2.save(book);
        return new Result(flag,flag ? "添加成功" : "添加失败");
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize,Book book) {
        IPage<Book> books = bookService2.getPage(currentPage, pageSize,book);

        //如果当前页大于需要查询的页码值,需要重新查询,使用最大页码值替换当前页码值
        if (currentPage > books.getPages()) {
            books = bookService2.getPage((int) books.getPages(),pageSize,book);
        }
        return new Result(books != null,books);
    }

}
