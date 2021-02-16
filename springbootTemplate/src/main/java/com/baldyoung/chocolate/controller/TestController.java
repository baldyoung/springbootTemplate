package com.baldyoung.chocolate.controller;

import com.baldyoung.chocolate.common.daoModule.DBConnectionTestDao;
import com.baldyoung.chocolate.common.redisModule.RedisConnectionTestService;
import com.baldyoung.chocolate.pojo.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.baldyoung.chocolate.pojo.dto.ResponseResult.success;

/**
 * 项目基础功能测试接口集
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private DBConnectionTestDao dbConnectionTestDao;

    @Autowired
    private RedisConnectionTestService redisConnectionTestService;

    @GetMapping
    public void requestTest(HttpServletResponse response) throws IOException {
        response.sendRedirect("test/index.html");
    }

    @GetMapping("restApi")
    public ResponseResult requestTestRestApi() {
        return success("rest接口请求成功");
    }

    @GetMapping("exceptionAdvice")
    public ResponseResult requestTestExceptionAdvice() throws Exception {
        throw new Exception("异常拦截器正常");
    }

    @GetMapping("dbConnection")
    public ResponseResult requestTestDBConnection() {
        return success(dbConnectionTestDao.showDataBaseCreateSQL());
    }

    @GetMapping("redisConnection")
    public ResponseResult requestTestRedisConnection() {
        redisConnectionTestService.test();
        return success();
    }
}
