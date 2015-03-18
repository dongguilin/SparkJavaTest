package com.guilin.sparkjava;

import static spark.Spark.get;

/**
 * Created with IntelliJ IDEA.
 * User: hadoop
 * Date: 15-3-18
 * Time: 下午2:16
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorld {

    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");

        // matches "GET /hello/foo" and "GET /hello/bar"
        // request.params(":name") is 'foo' or 'bar
        get("/hello/:name", (req, res) -> {
            return "hello:" + req.params(":name");
        });

        // matches "GET /say/hello/to/world"
        // request.splat()[0] is 'hello' and request.splat()[1] 'world'
        get("/say/*/to/*", (request, response) -> {
            return "Number of splat parameters:" + request.splat().length;
        });

        get("/request",(req,res)->{
            return req.body()+"<br>"
                    +req.cookies()+"<br>"
                    +req.contentLength()+"<br>"
                    +req.contentType()+"<br>"
                    +req.headers()+"<br>"
                    +req.headers("BAR");
        });

        get("/response",(req,res)->{
            res.body("Hello");
            res.header("FOO","bar");

            return res.body();
        });

        get("/params/:name/:age/:sex",(req,res)->{
            System.out.println("name:"+req.params(":name"));
            System.out.println("age:"+req.params(":age"));
            System.out.println("sex:"+req.params(":sex"));
            System.out.println(req.attributes());
            return req.params();
        });

    }
}
