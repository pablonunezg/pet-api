package com.pumapunku.pet.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Page<T>
{
    private List<T> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Integer total;

    public Boolean isLast()
    {
        return pageNumber + 1 >= totalPages();
    }

    public Integer totalPages()
    {
        if (content.isEmpty() && total == 0)
        {
            return 1;
        }
        else
        {
            return Double.valueOf(Math.ceil(total / pageSize)).intValue();
        }
    }

    public Integer size()
    {
        return this.content.size();
    }
}
