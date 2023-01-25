const path = require('path');
const TerserPlugin = require('terser-webpack-plugin');
const CssMinimizerPlugin = require('css-minimizer-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const WarningsToErrorsPlugin = require('warnings-to-errors-webpack-plugin');


module.exports = (env, argv) => ({
    entry: './src/main/resources/js/app.js',
    output: {
        path: path.resolve(__dirname, './target/classes/static'),
        filename: 'js/bundle.js'
    },
    devtool: argv.mode === 'production' ? false : 'eval-source-map',
    optimization: {
        minimize: true,
        minimizer: [
            new TerserPlugin(),
            new CssMinimizerPlugin()
        ]
    },
    plugins: [
        new MiniCssExtractPlugin({
            filename: "css/bundle.css"
        }),
        new WarningsToErrorsPlugin()
    ],
    module: {
        rules: [
            {
                test: /\.js$'/,
                include: path.resolve(__dirname, './src/main/resources/js'),
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env'],
                    },
                },
            },
            {
                test: /\.scss$/,
                include: path.resolve(__dirname, './src/main/resources/scss'),
                use: [
                    argv.mode === 'production' ? MiniCssExtractPlugin.loader : 'style-loader',
                    {
                        loader: 'css-loader',
                        options: {
                            importLoaders: 1,
                            sourceMap: true
                        }
                    },
                    {
                        loader: 'postcss-loader',
                        options: {
                            postcssOptions: {
                                plugins: [
                                    require('autoprefixer'),
                                ]
                            },
                            sourceMap: true
                        }
                    },
                    {
                        loader: 'sass-loader',
                        options: { sourceMap: true }
                    }
                ]
            }
        ]
    },
    resolve: {
        modules: [
            path.resolve(__dirname, './src/main/resources'),
            'node_modules'
        ],
    },
    devServer: {
        port: 8081,
        compress: true,
        watchFiles: [
            'src/main/resources/templates/**/*.html',
            'src/main/resources/js/**/*.js',
            'src/main/resources/scss/**/*.scss'
        ],
        proxy: {
            '**': {
                target: 'http://localhost:8080',
                secure: false,
                prependPath: false,
                headers: {
                    'X-Devserver': '1',
                }
            }
        }
    }
});
