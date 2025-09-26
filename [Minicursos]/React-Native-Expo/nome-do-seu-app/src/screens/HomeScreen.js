import React, { useEffect, useState } from "react";
import { View, StyleSheet, ImageBackground, Text, Dimensions, ActivityIndicator, ScrollView } from "react-native";
import Header from "../components/Header.js";
import MoviesScroll from "../components/MoviesScroll.js";
import Footer from "../components/Footer.js";
import { getPopularMovies } from "../api/api.js";

const { width } = Dimensions.get('window');

export default function HomeScreen() {
    const [featuredMovie, setFeaturedMovie] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        async function fetchFeaturedMovie() {
            try {
                const movies = await getPopularMovies();
                if (movies && movies.length > 0) {
                    setFeaturedMovie(movies[0]);
                }
            } catch (error) {
                console.error("Erro ao buscar filme em destaque:", error);
            } finally {
                setLoading(false);
            }
        }
        fetchFeaturedMovie();
    }, []);

    return (
        <View style={styles.container}>
            <Header title="🎬 Catálogo de Filmes" />

            <ScrollView style={styles.scrollContainer} showsVerticalScrollIndicator={false}>
                <View style={styles.heroContainer}>
                    {loading ? (
                        <View style={styles.loadingHero}>
                            <ActivityIndicator size="large" color="#e50914" />
                            <Text style={styles.loadingText}>Carregando filme em destaque...</Text>
                        </View>
                    ) : featuredMovie ? (
                        <ImageBackground
                            source={{
                                uri: `https://image.tmdb.org/t/p/original${featuredMovie.backdrop_path || featuredMovie.poster_path}`
                            }}
                            style={styles.hero}
                            resizeMode="cover"
                        >
                            <View style={styles.gradientOverlay} />

                            <View style={styles.heroContent}>
                                <View style={styles.badge}>
                                    <Text style={styles.badgeText}>EM DESTAQUE</Text>
                                </View>

                                <Text style={styles.heroTitle}>{featuredMovie.title}</Text>
                                <Text style={styles.heroSubtitle} numberOfLines={2}>
                                    {featuredMovie.overview || "Descubra os melhores filmes do momento"}
                                </Text>

                                <View style={styles.heroInfo}>
                                    <View style={styles.ratingBadge}>
                                        <Text style={styles.ratingText}>⭐ {featuredMovie.vote_average?.toFixed(1)}</Text>
                                    </View>
                                    <Text style={styles.yearText}>
                                        {featuredMovie.release_date ? new Date(featuredMovie.release_date).getFullYear() : ''}
                                    </Text>
                                    <Text style={styles.genreText}>
                                        {featuredMovie.adult ? '18+' : 'Livre'} • Popular
                                    </Text>
                                </View>
                            </View>

                            <View style={styles.bottomFade} />
                        </ImageBackground>
                    ) : (
                        <View style={styles.errorHero}>
                            <Text style={styles.errorText}>Erro ao carregar filme em destaque</Text>
                        </View>
                    )}
                </View>

                <MoviesScroll />
                
                <View style={styles.footerSpacing} />
            </ScrollView>

            <Footer />
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: "#fff",
    },
    scrollContainer: {
        flex: 1,
        marginBottom: 80,
    },
    heroContainer: {
        width: "100%",
        height: 300,
        backgroundColor: "#fff",
        padding: 10,
        marginBottom: 10,
    },
    hero: {
        width: "100%",
        height: "100%",
        justifyContent: "flex-end",
        borderRadius: 16,
        overflow: "hidden",
    },
    loadingHero: {
        width: "100%",
        height: "100%",
        justifyContent: "center",
        alignItems: "center",
        backgroundColor: "#f5f5f5",
        borderRadius: 16,
    },
    loadingText: {
        marginTop: 10,
        color: "#666",
        fontSize: 14,
    },
    errorHero: {
        width: "100%",
        height: "100%",
        justifyContent: "center",
        alignItems: "center",
        backgroundColor: "#f5f5f5",
        borderRadius: 16,
    },
    errorText: {
        color: "#666",
        fontSize: 16,
    },
    gradientOverlay: {
        position: "absolute",
        top: 0,
        left: 0,
        right: 0,
        bottom: 0,
        backgroundColor: "rgba(0,0,0,0.4)",
    },
    heroContent: {
        position: "absolute",
        bottom: 0,
        left: 0,
        right: 0,
        padding: 20,
        paddingBottom: 30,
    },
    badge: {
        alignSelf: "flex-start",
        backgroundColor: "#e50914",
        paddingHorizontal: 12,
        paddingVertical: 6,
        borderRadius: 20,
        marginBottom: 12,
    },
    badgeText: {
        color: "#fff",
        fontSize: 10,
        fontWeight: "bold",
        letterSpacing: 1,
    },
    heroTitle: {
        color: "#fff",
        fontSize: 28,
        fontWeight: "bold",
        marginBottom: 8,
        textShadowColor: "rgba(0,0,0,0.8)",
        textShadowOffset: { width: 0, height: 2 },
        textShadowRadius: 4,
    },
    heroSubtitle: {
        color: "#e0e0e0",
        fontSize: 16,
        marginBottom: 16,
        opacity: 0.9,
        textShadowColor: "rgba(0,0,0,0.6)",
        textShadowOffset: { width: 0, height: 1 },
        textShadowRadius: 2,
    },
    heroInfo: {
        flexDirection: "row",
        alignItems: "center",
        gap: 12,
    },
    ratingBadge: {
        backgroundColor: "rgba(255, 215, 0, 0.9)",
        paddingHorizontal: 8,
        paddingVertical: 4,
        borderRadius: 12,
    },
    ratingText: {
        color: "#000",
        fontSize: 12,
        fontWeight: "bold",
    },
    yearText: {
        color: "#fff",
        fontSize: 14,
        fontWeight: "600",
        textShadowColor: "rgba(0,0,0,0.8)",
        textShadowOffset: { width: 0, height: 1 },
        textShadowRadius: 2,
    },
    genreText: {
        color: "#ccc",
        fontSize: 14,
        textShadowColor: "rgba(0,0,0,0.8)",
        textShadowOffset: { width: 0, height: 1 },
        textShadowRadius: 2,
    },
    bottomFade: {
        position: "absolute",
        bottom: 0,
        left: 0,
        right: 0,
        height: 40,
        backgroundColor: "transparent",
    },
    footerSpacing: {
        height: 20,
    },
});
