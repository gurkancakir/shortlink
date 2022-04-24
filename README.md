# short-link
link sorter and redirect short code 

## swagger
https://test-sort.herokuapp.com/swagger-ui/index.html

## usage
1. create link \
    [POST] https://test-sort.herokuapp.com/api/v1/link
2. check code - link mapping \
    [GET] https://test-sort.herokuapp.com/api/v1/link/{code}/show
3. use code and redirect \
    [GET] https://test-sort.herokuapp.com/l/{code} \
    example : https://test-sort.herokuapp.com/l/H4PzVEoz

![](screenshots/swagger.png)

![](screenshots/create-link.png)

![](screenshots/check-link.png)

## graph capability

graphql client: https://test-sort.herokuapp.com/playground \
graphql api endpoint : https://test-sort.herokuapp.com/api/v1/graphql

![](screenshots/graph.png)

examples:
```json
mutation {
  createLink(request: {link: "https://www.test1.com"}) {
    code
    link
  }
}
```

![](screenshots/createLink.png)

```json
query {
  findByCodeEquals(code: "p45cu0UE") 
}
```

![](screenshots/findLinkByCode.png)

```json
query LIST_LINKS_PAGINATE {
    links (first: 2, after: "c2ltcGxlLWN1cnNvcjI=") {
        edges {
            cursor
            node {
              code
            }
        }
        pageInfo {
            startCursor
            endCursor
            hasPreviousPage
            hasNextPage
        }
    }
}
```
![](screenshots/paginate.png)