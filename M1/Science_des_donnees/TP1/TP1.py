import pandas
#from IPython.display import display


def main():
    passengers = pandas.read_csv('Dataset/Titanic.csv', sep='\t')

    print("Taille du dataframe :")
    print(passengers.shape)

    print("\nSix premières lignes du dataframe :")
    print(passengers.head(6))

    print("\nTrois dernières lignes du dataframe :")
    print(passengers.tail(3))

    print("\nCinq lignes au hasard du dataframe :")
    print(passengers.sample(5))

    print("\nInformations du cinquième passager :")
    print(passengers.loc[passengers["PassengerId"] == 5])

    print("\nInformations des passagers 10 à 16 :")
    print(passengers.iloc[10:17])

    print("\nInformations associées aux colonnes :")
    print(passengers.dtypes)

    print("\nInformations sur la colonne Name :")
    print()

    print("\nStatistiques de base du dataframe :")
    print(passengers.describe())

    print("\nNombre de survivants :")
    print(passengers.loc[passengers["Survived"] == 1, ["PassengerId"]].count())

    print("\nPar catégorie male/female, le nombre de personnes qui ont ou n'ont pas survécu :")
    print(passengers.groupby["Sex"].loc["Survived"].count())


main()
