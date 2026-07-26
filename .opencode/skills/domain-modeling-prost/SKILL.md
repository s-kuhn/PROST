---
name: domain-modeling-prost
description: PROST domain modeling and ubiquitous language. Use when defining or changing domain terms, lifecycle states, invariants, boundaries, or future Organizational Unit behavior.
---

# PROST Domain Modeling

- Start with `docs/architecture/arc42/12-glossary.md` and linked business rules.
- Distinguish identity accounts from PROST Consumer profiles.
- Prefer domain events and invariants over persistence or framework terminology.
- Challenge ambiguous synonyms and update the canonical glossary when the product owner decides a
  term.
- Model current MVP boundaries separately from future change scenarios.
- Do not introduce `Drinker`, `AStA`, or `Student Council` as canonical domain concepts.
- Record unresolved aggregate, lifecycle, and consistency choices as architecture inputs rather than
  silently deciding them.
