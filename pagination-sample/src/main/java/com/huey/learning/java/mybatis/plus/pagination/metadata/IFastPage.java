package com.huey.learning.java.mybatis.plus.pagination.metadata;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * @author huey
 */
public interface IFastPage<T> extends Serializable {

    /**
     * 获取排序信息，排序的字段和正反序
     *
     * @return 排序信息
     */
    List<OrderItem> orders();

    /**
     * KEY/VALUE 条件
     *
     * @return ignore
     */
    default Map<Object, Object> condition() {
        return null;
    }

    /**
     * 计算当前分页偏移量
     */
    default long offset() {
        return getCurrent() > 0 ? (getCurrent() - 1) * getSize() : 0;
    }

    /**
     * 当前分页总页数
     */
    default long getPages() {
        if (getSize() == 0) {
            return 0L;
        }
        long pages = getTotal() / getSize();
        if (getTotal() % getSize() != 0) {
            pages++;
        }
        return pages;
    }

    /**
     * 内部什么也不干
     * <p>只是为了 json 反序列化时不报错</p>
     */
    default IFastPage<T> setPages(long pages) {
        // to do nothing
        return this;
    }

    /**
     * 分页记录列表
     *
     * @return 分页对象记录列表
     */
    List<T> getRecords();

    /**
     * 设置分页记录列表
     */
    IFastPage<T> setRecords(List<T> records);

    /**
     * 当前满足条件总行数
     *
     * @return 总条数
     */
    long getTotal();

    /**
     * 设置当前满足条件总行数
     */
    IFastPage<T> setTotal(long total);

    /**
     * 获取每页显示条数
     *
     * @return 每页显示条数
     */
    long getSize();

    /**
     * 设置每页显示条数
     */
    IFastPage<T> setSize(long size);

    /**
     * 当前页，默认 1
     *
     * @return 当前页
     */
    long getCurrent();

    /**
     * 设置当前页
     */
    IFastPage<T> setCurrent(long current);

    /**
     * IPage 的泛型转换
     *
     * @param mapper 转换函数
     * @param <R>    转换后的泛型
     * @return 转换泛型后的 IPage
     */
    @SuppressWarnings("unchecked")
    default <R> IFastPage<R> convert(Function<? super T, ? extends R> mapper) {
        List<R> collect = this.getRecords().stream().map(mapper).collect(toList());
        return ((IFastPage<R>) this).setRecords(collect);
    }

    default IPage<T> toPage() {
        return new Page<>(this.getCurrent(), this.getSize(), this.getTotal(), false);
    }

}
