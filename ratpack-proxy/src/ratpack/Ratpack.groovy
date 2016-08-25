import ratpack.http.client.HttpClient

import static ratpack.groovy.Groovy.ratpack

static stream(client, ctx) {
  client.requestStream(URI.create("http://localhost:8080/${ctx.pathTokens.get('name')}")) { spec ->
    spec.method(ctx.request.method)
            .headers { headers -> headers.copy(ctx.request.headers) }
            .body { body -> ctx.request.body.then { b -> body.bytes(b.bytes) } }
  }
  .then { data -> data.forwardTo(ctx.response)}
}

ratpack {
  handlers {
    get('default/:name') { ctx ->
      stream(ctx.get(HttpClient), ctx)
    }
    get('pooled/:name') { ctx ->
      stream(HttpClient.of { client -> client.poolSize(1) }, ctx)
    }
  }
}
