package com.example.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by Frank on 5/24/17.
 */
@Builder
@Data
public class Page<T> {
    private int total; // 记录总数
    private int pageNo; // 页码
    private int pageSize; // 每页条数
    private List<T> list;
    private int pageMax;

    public Page() {
    }

    public Page(int total, int pageSize, int pageNo) {
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Page(List<T> list) {
        this.total = list.size();
        this.pageNo = 1;
        this.pageSize = this.total;
        this.list = list;
    }

    public Page(int total, int pageSize, int pageNo, List<T> list, int pageMax) {
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.list = list;
        this.pageMax = pageMax;
    }

    public int getOffset() {
        if (pageSize < 1) {
            pageSize = 10;
        }
        pageMax = (total - 1) / pageSize + 1;
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > pageMax) {
            pageNo = pageMax;
        }
        return pageSize * (pageNo - 1);
    }

}
