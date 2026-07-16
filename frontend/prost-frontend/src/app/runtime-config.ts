export interface RuntimeConfig {
  apiUrl: string;
  keycloak: {
    url: string;
    realm: string;
    clientId: string;
  };
}

const defaultConfig: RuntimeConfig = {
  apiUrl: 'http://localhost:8080/prost/api',
  keycloak: {
    url: 'http://localhost:8081',
    realm: 'prost',
    clientId: 'prost-frontend',
  },
};

let runtimeConfig: RuntimeConfig = defaultConfig;

export async function loadRuntimeConfig(): Promise<void> {
  try {
    const response = await fetch('/assets/config.json', {cache: 'no-store'});

    if (!response.ok) {
      return;
    }

    runtimeConfig = await response.json() as RuntimeConfig;
  } catch {
    runtimeConfig = defaultConfig;
  }
}

export function getRuntimeConfig(): RuntimeConfig {
  return runtimeConfig;
}
