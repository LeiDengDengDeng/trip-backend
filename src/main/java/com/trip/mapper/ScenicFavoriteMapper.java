package com.trip.mapper;

import com.trip.vo.ScenicFavoriteVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by cong on 2019-01-11.
 */
@Mapper
public interface ScenicFavoriteMapper {

    void insert(ScenicFavoriteVO scenicFavoriteVO);

    List<Integer> selectByUser(Integer userId);

    void delete(ScenicFavoriteVO scenicFavoriteVO);

    Integer select(ScenicFavoriteVO scenicFavoriteVO);
}
