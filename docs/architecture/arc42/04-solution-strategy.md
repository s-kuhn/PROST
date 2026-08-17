# 4. Solution Strategy

Documentation coverage: placeholder

No target solution strategy is accepted. The current prototype must not fill this section by
default.

## Decision Inputs

The strategy must explain how the accepted architecture satisfies:

- exact and atomic financial effects;
- auditable yet user-editable corrections;
- Consumer isolation and privileged MFA;
- local identities plus optional OIDC;
- low-burden self-hosting and recovery;
- A3 PDF generation and physical Tally snapshots;
- German and English responsive browser UI;
- future Organizational Units and coordinated ordering.

## Candidate Questions

- What system shape minimizes operational complexity while preserving explicit domain boundaries?
- Which identity approach meets the security outcomes without dominating installation and backup?
- Which frontend technology best fits mobile Consumer self-service and desktop settlement?
- What audit model reconciles editable workflows with immutable evidence?
- Which deployment packaging supports public HTTPS, external proxies, and private insecure mode
  safely?

Accepted answers belong in [ADRs](../decisions/README.md) and will be summarized here.
