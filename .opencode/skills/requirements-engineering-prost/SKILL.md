---
name: requirements-engineering-prost
description: PROST requirements elicitation and review. Use when discussing scope, stakeholders, capabilities, use cases, business rules, acceptance criteria, MVP boundaries, or requirement status.
---

# PROST Requirements Engineering

1. Read `docs/requirements/README.md`, `docs/requirements/glossary.md`, the relevant requirement
   files, and Arc42 sections 1, 2, 3, and 10.
2. Treat the human product owner as the only acceptance authority.
3. Ask focused questions and preserve each unresolved normative matter as an individual record under
   `docs/requirements/open-questions/`.
4. Follow `docs/governance/specification-governance.md` for revisions, maturity, lifecycle,
   delivery, and readiness. Keep acceptance-blocked artifacts in `draft`.
5. Use `CAP-###`, `UC-###`, and `BR-###` identifiers consistently.
6. Keep requirements technology-neutral unless documenting an accepted constraint.
7. Include actors, preconditions, trigger, main flow, alternatives, business-rule links, acceptance
   criteria, and open questions for each use case.
8. Check effects on identity, authorization, money, audit, privacy, operation, and future change
   scenarios.
9. Never infer business behavior from the prototype or the DrinkIt reference.
10. Prepare Product Owner reviews with
    `docs/governance/templates/specification-review-packet.md`; keep reviewer findings and their
    dispositions explicit.
11. Treat Open Question answers, deferrals, supersessions, reopenings, resolutions, and
    blocker-scope reductions as Product Owner actions. Agents may prepare but not authorize them.
