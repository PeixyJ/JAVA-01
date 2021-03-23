package io.kimmking.rpcfx.client;

import com.alibaba.fastjson.JSON;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.kimmking.rpcfx.api.RpcfxResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-03-22 15:26
 */
public interface RpcClient {
    public RpcfxResponse post(RpcfxRequest req, String url) throws IOException;
}
