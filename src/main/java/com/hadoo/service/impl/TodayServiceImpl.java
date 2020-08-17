package com.hadoo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hadoo.component.StringAndArray;
import com.hadoo.mapper.TodayMapper;
import com.hadoo.model.DailySpeech;
import com.hadoo.service.TodayService;
import com.hadoo.utils.DataMap;
import com.hadoo.utils.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: zhangocean
 * @Date: 2018/11/28 15:34
 * Describe:
 */
@Service
public class TodayServiceImpl implements TodayService {

    @Autowired
    TodayMapper todayMapper;


    @Override
    public DataMap publishISay(DailySpeech dailySpeech) {
        //设置发布时间
        dailySpeech.setPublishDate(new Date());
        todayMapper.save(dailySpeech);
        return DataMap.success();
    }

    @Override
    public DataMap getTodayInfo(int rows, int pageNum) {
        PageHelper.startPage(pageNum, rows);
        List<DailySpeech> dailySpeeches = todayMapper.getTodayInfo();
        PageInfo<DailySpeech> pageInfo = new PageInfo<>(dailySpeeches);

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        String pics = "";
        for(DailySpeech d : dailySpeeches){
            jsonObject = new JSONObject();
            jsonObject.put("content", d.getContent());
            jsonObject.put("mood", d.getMood());
            pics = d.getPicsUrl();
            if(pics != null && !StringUtil.BLANK.equals(pics)){
                jsonObject.put("picsUrl", StringAndArray.stringToArray(pics));
            }
            jsonObject.put("publishDate", d.getPublishDate().getTime());

            jsonArray.add(jsonObject);
        }

        JSONObject pageJson = new JSONObject();
        pageJson.put("pageNum",pageInfo.getPageNum());
        pageJson.put("pageSize",pageInfo.getPageSize());
        pageJson.put("total",pageInfo.getTotal());
        pageJson.put("pages",pageInfo.getPages());
        pageJson.put("isFirstPage",pageInfo.isIsFirstPage());
        pageJson.put("isLastPage",pageInfo.isIsLastPage());

        JSONObject returnJson = new JSONObject();
        returnJson.put("result", jsonArray);
        returnJson.put("pageInfo", pageJson);

        return DataMap.success().setData(returnJson);
    }
}
