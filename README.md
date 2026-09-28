# Week04 Book CRUD

## ① 프로젝트 소개

### 프로젝트 주제

Spring Boot와 Java를 이용한 도서 관리 REST API

도서 데이터를 메모리 기반 Map에 저장하고,
도서의 생성, 조회, 수정, 삭제 기능을 구현했다.

### 프로젝트 구조

```text
Controller
    ↓
Service
    ↓
BookRepository
    ↓
MemoryBookRepository
    ↓
Map<Long, Book>

### Book 데이터
- id: 도서 식별자
- title: 도서 제목
- author: 저자
- price: 가격
- category: 도서 카테고리
- isbn: ISBN 번호

### API Endpoint

| Method | URL | 기능 |
|---|---|---|
| POST | `/api/books` | 도서 생성 |
| GET | `/api/books` | 전체 도서 조회 |
| GET | `/api/books/{id}` | 특정 도서 조회 |
| PUT | `/api/books/{id}` | 도서 수정 |
| DELETE | `/api/books/{id}` | 도서 삭제 |

### 테스트 결과
- 리포지토리 내 result_image 폴더 안 사진

이번 과제 키워드
REST API
CRUD
Spring Boot
@RestController
@RequestBody
@PathVariable
Layered Architecture
Repository Interface
DTO
In-memory Repository
Map<Long, Book>

핵심 내용 정리
Controller, Service, Repository로 역할을 분리하는 Layered Architecture를 구현했다.
BookRequest와 BookResponse DTO를 사용하여 요청 데이터와 응답 데이터를 구분했다.
존재하지 않는 id를 요청했을때 404 Not Found를 반환하도록 구현했다.

4. Weekly Report
Key Learning
Spring Boot에서 REST API를 구현하는 방법을 학습했다.
CRUD Flow

HTTP Request → BookController → BookService → BookRepository → MemoryBookRepository → Map<Long, Book>

Problem & Solution

기존 Book 데이터가 id를 제외하고 title, author, price 세 개의 필드만 가지고 있었다.
과제에서 id를 제외한 5개 이상의 필드를 요구하는 것을 확인 후 category와 isbn을 추가했다.

Code Review
가장 중요하다고 생각한 코드는 BookService의 존재하지 않는 id 처리 부분이다.
존재하지 않는 데이터를 요청했을 때 404 Not Found를 반환하도록 처리하여 REST API의 동작을 명확하게 만들었다.

Reflection

이번 과제를 통해 REST API의 전체적인 요청 흐름을 이해할 수 있었다.
특히 Controller에서 받은 요청이 Service와 Repository를 거쳐 실제 데이터 저장 및 조회로 이어지는 과정을 직접 구현하면서 각 계층의 역할을 이해하게 되었다.