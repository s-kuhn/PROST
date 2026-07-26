# 5. Building Block View

Status: not decided

No target building blocks or module boundaries are accepted.

## Required Inputs

- Accepted use cases and business rules.
- Accepted system-shape, identity, persistence, and API ADRs.
- Explicit ownership of Consumer, Product, Tally, Settlement, Account, Organization, and audit data.
- Allowed dependencies and transactional boundaries.

## Expected Levels

Once decided, this chapter will document:

1. The complete PROST system as a black box.
2. Top-level deployable or logical building blocks.
3. Internal domain/application boundaries where they materially affect change, correctness, or
   security.

The package layout of the current Spring prototype is not evidence of target module boundaries.
