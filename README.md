
## API Kullanımı

#### Tüm Blogları getir

```http
  GET /api/v1/blogs/list/limit/?
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `limit` | `int` | **Gerekli**. Limit. |

<pre><code>
{
  "timeStamp": "2021-11-24T23:28:55.8922002",
  "statusCode": 200,
  "httpStatus": "OK",
  "message": "listed contents",
  "data": {
    "blogs": [
      {
        "id": 0,
        "content": "veri tabanında güncelleme işlemleri nasıl mı yapılır ? Gelin anlatalım",
        "publicationDate": "2021-11-24T23:28:56.0532927",
        "author": "FURKAN ÖZMEN"
      },
      {
        "id": 0,
        "content": "blog content...",
        "publicationDate": "2021-11-24T23:28:56.0559275",
        "author": "FURKAN ÖZMEN"
      }
    ]
  }
}
</code></pre>


#### blog create
```http
  POST /api/v1/blogs/blog/content
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `content`  | `string` | **Gerekli**. blog content |
| `videoUrl`| `string` | **Gerekli**. embedded videoUrl |
| `publicationDate`      | `LocalDateTime` | **Gerekli**. publicationDate |
| `updateAt`      | `LocalDateTime` |   updateAt |
| `id`      | `int` |   author.id |
| `authorName`      | `String` |    |

<pre><code>
{
  "timeStamp": "2021-11-25T00:16:51.0814225",
  "statusCode": 201,
  "httpStatus": "CREATED",
  "message": "created blog",
  "data": {
    "blogs": {
      "id": 0,
      "content": "string",
      "publicationDate": "2021-11-25T00:16:51.0876849",
      "author": "Furkan Özmen"
    }
  }
}
</code></pre>


#### belirli id'ye göre blog getir
```http
  GET api/v1/blogs/{id}
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `id` | `int` | **Gerekli**. blog id |

<pre><code>
{
  "timeStamp": "2021-11-25T00:18:46.4577028",
  "statusCode": 200,
  "httpStatus": "OK",
  "message": "listed contents",
  "data": {
    "blogs": {
      "id": 0,
      "content": "veri tabanında güncelleme işlemleri nasıl mı yapılır ? Gelin anlatalım",
      "publicationDate": "2021-11-25T00:18:46.4793499",
      "author": "FURKAN ÖZMEN"
    }
  }
}
</code></pre>

#### Güncelle
```http
  PUT /api/v1/blogs/update/{id}
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `id` | `int` | **Gerekli**. blog id |


#### Sil
```http
  DELETE /api/v1/blogs/delete/{id}
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `id` | `int` | **Gerekli**. blog id |

#### Tüm Yazarları getir

```http
  GET //api/v1/authors/get/authors
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `` | `` |  |


#### author yarat
```http
  POST /api/v1/authors/create
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `authorFullNanme` | `String` | **Gerekli**. full name |

<pre><code>
</code></pre>


  