---
title: Research References
document_status: research
source: Repository research on 2026-07-26
---

# Research References

## DrinkIt

- Repository: [asta-kit/drinkit](https://github.com/asta-kit/drinkit)
- License: CC0-1.0
- Role: legacy workflow reference only

The repository demonstrates an established workflow that generates a paper tally sheet, maintains
Consumers and Products, enters counted consumption in a batch, derives balances from transactions,
records money manually, and sends balance emails.

The upstream generator uses ReportLab flowables on an A3 landscape page. It specifies quarter-inch
page margins, a two-inch existing-name column, one-third-inch Consumer rows, equal-width Product
columns, an automatically sized heading row, and a separate handwritten-registration table. These
correspond to approximately 6.35 mm margins, a 50.8 mm name column, and 8.47 mm rows. It does not
repeat a split table's heading, validate physical marking width, generate a preview, or place QR codes.
Observed deployment PDFs may contain local changes not present in the upstream repository.

PROST does not treat DrinkIt code, terminology, data structures, or incidental behavior as
requirements. This requirements set was elicited from the product owner and deliberately differs in
areas such as self-service account access, explicit Tally state, audited corrections,
provider-neutral identity, and email scope.

## Current PROST Prototype

The implementation in this repository demonstrates possible technologies and integration
experiments. Its `/v1/test`, `/v1/sec`, Books UI, role names, database test table, and Keycloak
event-listener behavior are not product requirements. See
the [current-state inventory](../architecture/current-state.md).

## Initial PROST README

- Source: Historical `docs/README.md` at the initial repository revision
- Role: Future-scope research input only

The initial README listed supplier invoices (`CAP-009`), Organization balance tracking based on
Consumer Deposits and supplier invoices (`CAP-012`), internal and external sales-price calculation
(`CAP-013` and `CAP-014`), goods exchange between Organizations (`CAP-015`), and sales and
bottle-loss reporting by day, week, month, or year (`CAP-016`). These ideas are preserved in
[Business Capabilities](capabilities.md), but the README does not define accepted product behavior.
