package cn.kissshot.rpc;

import cn.kissshot.rpc.req.ActivityReq;
import cn.kissshot.rpc.res.ActivityRes;

public interface IActivityBooth {
    ActivityRes queryActivityById(ActivityReq req);

}
