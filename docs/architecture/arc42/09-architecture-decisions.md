# 9. Architecture Decisions

Status: not decided

Architecture decisions are maintained as
separate [Architecture Decision Records](../decisions/README.md).

No ADR has been accepted.

## Planned Decision Areas

| Area                               | Requirement Drivers                                     |
|------------------------------------|---------------------------------------------------------|
| System shape and module boundaries | `QS-COR-*`, `QS-MNT-*`                                  |
| Identity and MFA                   | `UC-001`, `UC-010`, `QS-SEC-*`                          |
| Frontend technology                | `UC-006`, `UC-009`, `QS-USA-*`, `QS-MNT-002`            |
| Persistence and audit model        | `BR-004`, `BR-005`, `BR-007`, `QS-COR-*`                |
| API contract strategy              | Consumer isolation, client consistency, maintainability |
| PDF generation                     | `UC-004`, `BR-002`, `BR-006`                            |
| Deployment and TLS                 | `QS-OPS-*`, `QS-SEC-003`                                |
| Backup and restore                 | `QS-OPS-003`                                            |

The table is a work queue, not an implied decision or sequence of implementation.
