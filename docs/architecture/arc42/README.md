# PROST Arc42 Documentation

Documentation coverage: partial

This directory is a derived view of the target architecture. Accepted requirements, quality
scenarios, Architecture Decision Records, and governance policies remain authoritative. The current
prototype is described separately in [Current Technical State](../current-state.md).

## Chapters

1. [Introduction And Goals](01-introduction-and-goals.md)
2. [Constraints](02-constraints.md)
3. [Context And Scope](03-context-and-scope.md)
4. [Solution Strategy](04-solution-strategy.md)
5. [Building Block View](05-building-block-view.md)
6. [Runtime View](06-runtime-view.md)
7. [Deployment View](07-deployment-view.md)
8. [Crosscutting Concepts](08-crosscutting-concepts.md)
9. [Architecture Decisions](09-architecture-decisions.md)
10. [Quality Requirements](10-quality-requirements.md)
11. [Risks And Technical Debt](11-risks-and-technical-debt.md)
12. [Glossary](12-glossary.md)

## Documentation Rules

- Accepted detailed requirements in [`docs/requirements/`](../../requirements/README.md) are the
  product source of truth.
- Arc42 summarizes architecture-relevant requirements and links to details.
- Chapter documentation coverage is `placeholder`, `partial`, or `current`; it is not specification
  acceptance and cannot establish a product requirement or architecture decision.
- Mermaid is the diagram source format.
- Undecided target architecture remains explicit rather than being inferred from the prototype.
- Important choices are recorded as ADRs under [
  `docs/architecture/decisions/`](../decisions/README.md).
- Only the human Product Owner may accept controlled specifications or ADRs through the governed
  pull-request process.

## Arc42 Attribution

This structure is adapted from the [arc42](https://arc42.org) architecture documentation template
created by Peter Hruschka and Gernot Starke. The arc42 template is licensed
under [Creative Commons Attribution-ShareAlike 4.0 International](https://creativecommons.org/licenses/by-sa/4.0/).
PROST-specific content is original project documentation.
