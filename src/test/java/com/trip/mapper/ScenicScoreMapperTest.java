package com.trip.mapper;

import com.trip.vo.ScenicScoreVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cong on 2018-12-31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScenicScoreMapperTest {

    @Autowired
    private ScenicScoreMapper scenicScoreMapper;

    @Test
    public void addScore(){
        ScenicScoreVO scoreVO=new ScenicScoreVO();
        scoreVO.setScore(1);
        scoreVO.setUserId(1);
        scoreVO.setScenicId(2);
        scenicScoreMapper.insertSelective(scoreVO);
    }

    @Test
    public void updateScore(){
        ScenicScoreVO scoreVO=new ScenicScoreVO();
        scoreVO.setScore(2);
        scoreVO.setUserId(1);
        scoreVO.setScenicId(2);
        scenicScoreMapper.update(scoreVO);
    }

}
