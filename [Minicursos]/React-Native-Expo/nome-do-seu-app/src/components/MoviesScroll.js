import React, { useEffect, useState } from "react";
import { ScrollView, View, Text, Image, StyleSheet, ActivityIndicator, Dimensions } from "react-native";
import { getPopularMovies } from "../api/api.js";

const { width } = Dimensions.get('window');
const cardWidth = width * 0.4;

export default function MoviesScroll() {
    const [movies, setMovies] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        async function fetchData() {
            const data = await getPopularMovies();
            setMovies(data);
            setLoading(false);
        }
        fetchData();
    }, []);

    if (loading) {
        return (
            <View style={styles.loadingContainer}>
                <ActivityIndicator size="large" color="#e50914" />
                <Text style={styles.loadingText}>Carregando filmes...</Text>
            </View>
        );
    }

    return (
        <View style={styles.container}>
            <Text style={styles.sectionTitle}>Filmes Populares</Text>

            <ScrollView
                horizontal
                showsHorizontalScrollIndicator={false}
                contentContainerStyle={styles.scrollContent}
                style={styles.ScrollView}
            >
                {movies.map((movie, index) => (
                    <View key={movie.id || index} style={styles.card}>
                        <View style={styles.imageContainer}>
                            <Image 
                                source={{ uri: `https://image.tmdb.org/t/p/w500${movie.poster_path}` }}
                                style={styles.poster}
                                resizeMode="cover"
                            />
                            <View style={styles.overlay}>
                                <Text style={styles.title} numberOfLines={2}>{movie.title}</Text>
                            </View>
                        </View>

                        <View style={styles.cardContent}>
                            <View style={styles.ratingContainer}>
                                <Text style={styles.rating}>⭐ {movie.vote_average?.toFixed(1)}</Text>
                                <Text style={styles.year}>
                                    {movie.release_date ? new Date(movie.release_date).getFullYear() : ''}
                                </Text>
                            </View>

                            <Text style={styles.overview} numberOfLines={1}>
                                {movie.overview}
                            </Text>
                        </View>
                    </View>
                ))}
            </ScrollView>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        paddingVertical: 20,
    },
    sectionTitle: {
        fontSize: 24,
        fontWeight: "bold",
        marginHorizontal: 16,
        marginBottom: 16,
        color: "#333",
    },
    loadingContainer: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        paddingVertical: 50,
    },
    loadingText: {
        marginTop: 10,
        color: "#666",
        fontSize: 14,
    },
    ScrollView: {
        paddingLeft: 16,
    },
    scrollContent: {
        paddingRight: 16,
    },
    card: {
        width: cardWidth,
        marginRight: 16,
        backgroundColor: "#fff",
        borderRadius: 12,
        elevation: 3,
        shadowColor: "#000",
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.1,
        shadowRadius: 4,
    },
    imageContainer: {
        position: "relative",
        borderTopLeftRadius: 12,
        borderTopRightRadius: 12,
        overflow: "hidden",
    },
    poster: {
        width: "100%",
        height: 200,
    },
    overlay: {
        position: "absolute",
        bottom: 0,
        left: 0,
        right: 0,
        backgroundColor: "rgba(0,0,0,0.7)",
        padding: 8,
    },
    title: {
        color: "#fff",
        fontSize: 14,
        fontWeight: "bold",
    },
    cardContent: {
        padding: 12,
    },
    ratingContainer: {
        flexDirection: "row",
        justifyContent: "space-between",
        alignItems: "center",
        marginBottom: 8,
    },
    rating: {
        fontSize: 12,
        fontWeight: "600",
        color: "#f39c12",
    },
    year: {
        fontSize: 12,
        color: "#666",
    },
    overview: {
        fontSize: 12,
        color: "#999",
        lineHeight: 16,
    },
});
