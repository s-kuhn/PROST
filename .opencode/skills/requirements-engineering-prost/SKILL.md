---
name: requirements-engineering-prost
description: PROST requirements elicitation and review. Use when discussing scope, stakeholders, capabilities, use cases, business rules, acceptance criteria, MVP boundaries, or requirement status.
---

# PROST Requirements Engineering

1. Read `docs/requirements/README.md`, `docs/requirements/glossary.md`, the relevant requirement
   files, and Arc42 sections 1, 2, 3, and 10.
2. Treat the human product owner as the only acceptance authority.
3. Ask focused questions and preserve unresolved matters as explicit open questions.
4. Follow `docs/governance/specification-governance.md` for revisions, maturity, lifecycle,
   delivery, and readiness. Keep acceptance-blocked artifacts in `draft`.
5. Use `CAP-###`, `UC-###`, and `BR-###` identifiers consistently.
6. Keep requirements technology-neutral unless documenting an accepted constraint.
7. Include actors, preconditions, trigger, main flow, alternatives, business-rule links, acceptance
   criteria, and open questions for each use case.
8. Check effects on identity, authorization, money, audit, privacy, operation, and future change
   scenarios.
9. Never infer business behavior from the prototype or the DrinkIt reference.
