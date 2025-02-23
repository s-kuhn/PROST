# PROST

Planning, Reporting, Ordering, Stock, Tally (web app aimed primarily at volunteer associations)

This is a web application for associations to manage their drinks and snacks. It is aimed at
associations that have a bar or a canteen and want to keep track of their stock and sales. It is
also aimed at associations that want to keep track of their members' debts and credits.


## Use cases:

- Create members (invitation via one-time-link)
- Create a tally (printable template)
- Keeping a balance sheet of the members
- Provide members with insight (own balance sheet only, payment options)
- Create a stock (add new items, remove items, etc.)
- Order from suppliers (if API available)
- Input invoices
- Keep balance sheet of the association
- Price calculation for internal sales
- Price calculation for external sales
- Calculation for exchange of goods between associations
- Reporting (e.g. sales per day, week, month, year, loss of bottles, etc.)

## Technologies:
- Backend:
  - Kotlin
  - Spring Boot Modulith & WebMVC
  - Maven
  - Auth via [Keycloak](https://www.keycloak.org/)
  - OpenAPI
- Frontend:
  - tbd (Angular, Vue, Flutter)
- Database:
  - PostgreSQL
  - Flyway
- DevOps:
  - Semantic Versioning
  - Docker
  - GitHub Actions (CI/CD, Secrets, Environments)
  - Dependabot
  - CodeStyle

## Installation:
- Clone the repository
- Install Docker
- Setup environment variables (see [.env.example](/.env.example))
- Start the database in the [docker-compose.yaml](../docker/docker-compose.yaml)
- Load maven project
- Run the application

## Versioning and Branch-Strategy
Branch-conventions:
  - `main`: Contains stabile version for production.
  - `dev`: Contains features and bugfixes used for testing.
Versioning strategie:
  - `MAJOR.MINOR.PATCH`:
    - **PATCH** is incremented for bugfixes.
    - **MINOR** is incremented for new features without breaking changes.
    - **MAJOR** is incremented manually for breaking changes.
  - Automatic incrementation via labels on PRs into `dev`.
  - Only one of the following labels can be set at a time:
    - `breaking-changes`
    - `feature`
    - `bugfix`

## How to start dev env local
```bash
docker compose --env-file .env.dev -p "dev_prost" -f "./docker/docker-compose.dev.yaml" up
```

## How to start prod env local
```bash
docker compose --env-file .env.prod -p "prod_prost" -f "./docker/docker-compose.prod.yaml" up
```
