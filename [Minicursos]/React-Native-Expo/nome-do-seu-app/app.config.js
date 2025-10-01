export default ({ config }) => ({
  ...config,
  extra: {
    API_KEY: process.env.API_KEY,
    BASE_URL: process.env.BASE_URL,
  },
});
