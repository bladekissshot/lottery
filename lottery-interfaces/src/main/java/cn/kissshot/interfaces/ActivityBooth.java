package cn.kissshot.interfaces;

import common.Constants;
import common.Result;
import cn.kissshot.infra.dao.IActivityDao;
import cn.kissshot.rpc.IActivityBooth;
import cn.kissshot.rpc.dto.ActivityDto;
import org.apache.dubbo.config.annotation.Service;
import cn.kissshot.infra.po.Activity;
import cn.kissshot.rpc.req.ActivityReq;
import cn.kissshot.rpc.res.ActivityRes;

import javax.annotation.Resource;

@Service
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {

        Activity activity = activityDao.queryActivityById(req.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
    }

}

