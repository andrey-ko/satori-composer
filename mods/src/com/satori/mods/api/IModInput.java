package com.satori.mods.api;

import com.satori.mods.core.async.*;

import com.fasterxml.jackson.databind.*;

public interface IModInput {
  void process(JsonNode data, IAsyncHandler cont) throws Exception;
  default IAsyncFuture process(JsonNode data) throws Exception{
    AsyncFuture future = new AsyncFuture();
    process(data, future);
    return future;
  }
}
