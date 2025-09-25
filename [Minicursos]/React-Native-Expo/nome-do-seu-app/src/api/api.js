import Constants from 'expo-constants';

const { API_KEY, BASE_URL } = Constants.expoConfig?.extra || {};

export async function getPopularMovies() {
  try {
    const response = await fetch(
      `${BASE_URL}/movie/popular?api_key=${API_KEY}&language=pt-BR`
    );
    const json = await response.json();
    return json.results;
  } catch (error) {
    console.error("Erro ao buscar filmes:", error);
    return [];
  }
}