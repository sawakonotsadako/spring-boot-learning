package com.yl.demo.learning.controller;

import com.yl.demo.learning.config.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
public class WebSocketController {

    @RequestMapping(value = "/websocket/{cid}/{message}", method = RequestMethod.GET)
    public void push(@PathVariable String cid, @PathVariable String message) {

        try {
            WebSocketServer.sendInfo(message, cid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
